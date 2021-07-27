namespace FrontWeb.Controllers
{
    using DataWork.UoW;
    using Library.Context.Models;
    using Library.Context.Services;
    using Microsoft.AspNetCore.Mvc;
    using System;
    using System.Linq;

    public class HomeController : Controller
    {
        private readonly IUoW _unitOfWork;
        private readonly IUserService userService;
        private readonly ICryptoService cryptoService;

        public HomeController(IUoW uoW, IUserService userService, ICryptoService cryptoService)
        {            
            _unitOfWork = uoW;
            this.userService = userService;
            this.cryptoService = cryptoService;
        }

        [HttpGet]
        public IActionResult Contacts()
        {
            if (Request.Cookies.ContainsKey("Role"))
            {
                string Id = Request.Cookies["Id"];
                int id = Int32.Parse(Id);
                var contacts = _unitOfWork.userRepository.GetUser(u => u.UserId == id).Contacts.AsEnumerable().OrderBy(x => x.ContactSurname);
                return View(contacts);
            }
            else
            {
                return new RedirectResult("/Auth/Login");
            }
        }

        [HttpGet]
        public IActionResult Users()
        {
            if (Request.Cookies.ContainsKey("Role"))
            {
                if (Request.Cookies["ROLE"].Equals(cryptoService.SHA256GetHash("ROLE_ADMIN")))
                {
                    return View(_unitOfWork.userRepository.GetUsers());
                }
                return new RedirectResult("/Auth/Login");
            }
            else
            {
                return new RedirectResult("/Auth/Login");
            }
        }

        [HttpGet]
        public IActionResult DeleteUser(int id)
        {
            if (Request.Cookies.ContainsKey("Role"))
            {
                if (Request.Cookies["ROLE"].Equals(cryptoService.SHA256GetHash("ROLE_ADMIN")))
                {
                    _unitOfWork.contactsRepository.RemoveRange(_unitOfWork.userRepository.GetUser(u => u.UserId == id).Contacts.AsEnumerable());
                    _unitOfWork.contactsRepository.Save();
                    _unitOfWork.userRepository.Remove(u => u.UserId == id);
                    _unitOfWork.userRepository.Save();
                    return new RedirectResult("/Home/Users");
                }
                return new RedirectResult("/Auth/Login");
            }
            else
            {
                return new RedirectResult("/Auth/Login");
            }
        }
        
        [HttpGet]
        public IActionResult CreateContact()
        {
            if (Request.Cookies.ContainsKey("Role"))
            {
                return View();
            }
            else
            {
                return new RedirectResult("/Auth/Login");
            }
            
        }

        [HttpPost]
        public IActionResult CreateContact(Contact contact)
        {
            if (Request.Cookies.ContainsKey("Role"))
            {
                string Id = Request.Cookies["Id"];
                int id = Int32.Parse(Id);
                userService.CreateContact(id, contact);
                return new RedirectResult("/Home/Contacts");
            }
            else
            {
                return new RedirectResult("/Auth/Login");
            }
        }

        [HttpGet]
        public IActionResult DeleteContact(int id)
        {
            _unitOfWork.contactsRepository.Remove(c => c.ContactId == id);
            _unitOfWork.contactsRepository.Save();
            return new RedirectResult("/Home/Contacts");
        }

        [HttpPost]
        public IActionResult Exit()
        {
            if (Request.Cookies.ContainsKey("ROLE"))
            {
                Response.Cookies.Delete("ROLE");
            }
            if (Request.Cookies.ContainsKey("Id"))
            {
                Response.Cookies.Delete("Id");
            }
            return new RedirectResult("/Auth/Login");
        }

        [HttpGet]
        public IActionResult UpdateContact(int id)
        {
            if(Request.Cookies.ContainsKey("ChangeCntcId"))
            {
                Response.Cookies.Delete("ChangeCntcId");
            }
            Response.Cookies.Append("ChangeCntcId", id.ToString());
            var contact = _unitOfWork.contactsRepository.Get(x => x.ContactId == id);
            return View(contact);
        }

        [HttpPost]
        public IActionResult UpdateContact(Contact contact)
        {
            int id = Int32.Parse(Request.Cookies["ChangeCntcId"]);
            var oldContact = _unitOfWork.contactsRepository.Get(x => x.ContactId == id);
            oldContact.ContactName = contact.ContactName;
            oldContact.ContactSurname = contact.ContactSurname;
            oldContact.PhoneNumber = contact.PhoneNumber;
            _unitOfWork.contactsRepository.Update(oldContact);
            return new RedirectResult("/Home/Contacts");
        }

        public IActionResult Privacy()
        {
            return View();
        }
    }
}
