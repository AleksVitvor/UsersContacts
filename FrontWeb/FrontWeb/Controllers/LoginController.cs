using Library.Context;
using Library.FrontModels;
using Microsoft.AspNetCore.Mvc;
using System.Net.Http;
using System.Net.Http.Json;

namespace FrontWeb.Controllers
{
    public class LoginController : Controller
    {
        IHttpClientFactory HttpClientFactory;
        private AppContextDB context;
        public LoginController(IHttpClientFactory httpClientFactory, AppContextDB contextDB)
        {
            this.HttpClientFactory = httpClientFactory;
            context = contextDB;
        }
        [HttpGet]
        public ActionResult Login()
        {
            return View();
        }

        [HttpGet]
        public ActionResult Register()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Register(FrontUserForLogging userForLogging)
        {
            HttpClient client = HttpClientFactory.CreateClient();
            client.PostAsJsonAsync("http://localhost:8080/register", userForLogging);
            return new RedirectResult("/Login/Login");
        }
        [HttpPost]
        public ActionResult Login(AuthLogin authLogin)
        {
            HttpClient client = HttpClientFactory.CreateClient();
            client.PostAsJsonAsync("http://localhost:8080/auth", authLogin);
            return new RedirectResult("/Login/Login");
        }
    }
}
