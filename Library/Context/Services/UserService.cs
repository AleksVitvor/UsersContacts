namespace Library.Context.Services
{
    using Library.Context.Models;
    using Library.FrontModels;
    using System.Linq;
    using System.Security.Cryptography;
    using System.Text;

    public class UserService : IUserService
    {
        readonly AppContextDB context;

        public UserService(AppContextDB contextDB)
        {
            context = contextDB;
        }

        public void Register(FrontUserForLogging userForLogging)
        {
            var user = new User()
            {
                Username = userForLogging.UserName,
                Password = Encoding.Default.GetString(SHA256.Create().ComputeHash(Encoding.Default.GetBytes(userForLogging.Password))),
                RoleId = 1
            };

            context.Users.Add(user);
            context.SaveChanges();
        }

        public User Auth(AuthLogin login)
        {
            return context.Users.FirstOrDefault(u => u.Username == login.UserName
                && u.Password == Encoding.Default.GetString(SHA256.Create().ComputeHash(Encoding.Default.GetBytes(login.Password))));
        }

        public void CreateContact(int userId, Contact contact)
        {
            contact.UserID = userId;
            context.Contacts.Add(contact);
            context.SaveChanges();
        }
    }
}
