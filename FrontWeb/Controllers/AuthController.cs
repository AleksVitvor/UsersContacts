namespace FrontWeb.Controllers
{
    using Library.Context.Models;
    using Library.Context.Services;
    using Library.FrontModels;
    using Microsoft.AspNetCore.Mvc;
    using System.Security.Cryptography;
    using System.Text;

    public class AuthController : Controller
    {
        private readonly IUserService userService;

        public AuthController(IUserService userService)
        {
            this.userService = userService;
        }

        [HttpGet]
        public ActionResult Login()
        {
            if (Request.Cookies.ContainsKey("ROLE"))
            {
                Response.Cookies.Delete("ROLE");
            }
            return View();
        }

        [HttpGet]
        public ActionResult Register()
        {
            if (Request.Cookies.ContainsKey("ROLE"))
            {
                Response.Cookies.Delete("ROLE");
            }
            return View();
        }

        [HttpPost]
        public ActionResult Register(FrontUserForLogging userForLogging)
        {
            if (Request.Cookies.ContainsKey("ROLE"))
            {
                Response.Cookies.Delete("ROLE");
            }

            userService.Register(userForLogging);
            return new RedirectResult("/Auth/Login");
        }
        [HttpPost]
        public ActionResult Login(AuthLogin authLogin)
        {
            if(Request.Cookies.ContainsKey("ROLE"))
            {
                Response.Cookies.Delete("ROLE");
            }

            User user = userService.Auth(authLogin);

            if (user != null)
            {
                Response.Cookies.Append("ROLE",
                    Encoding.Default.GetString(SHA256.Create().ComputeHash(Encoding.Default.GetBytes(user.Role.RoleName))));
                Response.Cookies.Append("Id", user.UserId.ToString());
                return new RedirectResult("/Home/Contacts");
            }
            else
            {
                return new RedirectResult("/Auth/Login");
            }
        }
    }
}
