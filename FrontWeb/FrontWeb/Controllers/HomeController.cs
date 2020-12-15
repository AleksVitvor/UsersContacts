using FrontWeb.Models;
using Library.Context;
using Library.Context.Models;
using Library.Context.Services;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Diagnostics;
using System.Linq;

namespace FrontWeb.Controllers
{
    public class HomeController : Controller
    {
        private AppContextDB contextDB;
        public HomeController(AppContextDB contextDB)
        {
            this.contextDB = contextDB;
        }
        [HttpGet]
        public IActionResult Contacts()
        {
            if (Request.Cookies.ContainsKey("Role"))
            {
                string Id = Request.Cookies["Id"];
                int id = Int32.Parse(Id);
                return View(contextDB.Users.FirstOrDefault(u => u.UserId == id).Contacts.AsEnumerable());
            }
            else
                return new RedirectResult("/Auth/Login");
        }

        [HttpGet]
        public IActionResult Users()
        {
            if (Request.Cookies.ContainsKey("Role"))
            {
                if (Request.Cookies["ROLE"].Equals(System.Text.Encoding.UTF8.GetString(System.Security.Cryptography.SHA256.Create().ComputeHash(System.Text.Encoding.UTF8.GetBytes("ROLE_ADMIN")))))
                {
                    return View(contextDB.Users.AsEnumerable());
                }
                return new RedirectResult("/Auth/Login");
            }
            else
                return new RedirectResult("/Auth/Login");
        }
        [HttpGet]
        public IActionResult DeleteUser(int id)
        {
            if (Request.Cookies.ContainsKey("Role"))
            {
                if (Request.Cookies["ROLE"].Equals(System.Text.Encoding.UTF8.GetString(System.Security.Cryptography.SHA256.Create().ComputeHash(System.Text.Encoding.UTF8.GetBytes("ROLE_ADMIN")))))
                {
                    contextDB.Contacts.RemoveRange(contextDB.Users.FirstOrDefault(u => u.UserId == id).Contacts.AsEnumerable());
                    contextDB.SaveChanges();
                    contextDB.Users.Remove(contextDB.Users.FirstOrDefault(u => u.UserId == id));
                    contextDB.SaveChanges();
                    return new RedirectResult("/Home/Users");
                }
                return new RedirectResult("/Auth/Login");
            }
            else
                return new RedirectResult("/Auth/Login");
        }
        
        [HttpGet]
        public IActionResult CreateContact()
        {
            if (Request.Cookies.ContainsKey("Role"))
            {
                return View();
            }
            else
                return new RedirectResult("/Auth/Login");
            
        }
        [HttpPost]
        public IActionResult CreateContact(Contact contact)
        {
            if (Request.Cookies.ContainsKey("Role"))
            {
                string Id = Request.Cookies["Id"];
                int id = Int32.Parse(Id);
                Service service = new Service(contextDB);
                service.CreateContact(id, contact);
                return new RedirectResult("/Home/Contacts");
            }
            else
                return new RedirectResult("/Auth/Login");
        }
        [HttpGet]
        public IActionResult DeleteContact(int id)
        {
            contextDB.Contacts.Remove(contextDB.Contacts.FirstOrDefault(c => c.ContactId == id));
            contextDB.SaveChanges();
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

        public IActionResult Privacy()
        {
            return View();
        }
    }
}
