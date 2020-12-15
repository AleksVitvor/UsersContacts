using Library.Context.Models;
using Library.FrontModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace Library.Context.Services
{
    public class Service
    {
        AppContextDB app;
        public Service(AppContextDB contextDB)
        {
            app = contextDB;
        }
        public void Register(FrontUserForLogging userForLogging)
        {
            app.Users.Add(
                new User()
                {
                    Username = userForLogging.UserName,
                    Password = Encoding.UTF8.GetString(SHA256.Create().ComputeHash(Encoding.UTF8.GetBytes(userForLogging.Password))), 
                    RoleId=1
                });
            app.SaveChanges();
        }
        public User Auth(AuthLogin login)
        {
            return app.Users.FirstOrDefault(u => u.Username == login.UserName
                && u.Password == Encoding.UTF8.GetString(SHA256.Create().ComputeHash(Encoding.UTF8.GetBytes(login.Password))));
        }
        public void CreateContact(int userId, Contact contact)
        {
            contact.UserID = userId;
            app.Contacts.Add(contact);
            app.SaveChanges();
        }
    }
}
