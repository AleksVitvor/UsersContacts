namespace Library.Context.Services
{
    using Library.Context.Models;
    using Library.FrontModels;
    using System.Linq;

    public class UserService : IUserService
    {
        private readonly AppContextDB context;

        private readonly ICryptoService cryptoService;

        public UserService(AppContextDB contextDB, ICryptoService cryptoService)
        {
            context = contextDB;
            this.cryptoService = cryptoService;
        }

        public void Register(FrontUserForLogging userForLogging)
        {
            var user = new User()
            {
                Username = userForLogging.UserName,
                Password = cryptoService.SHA256GetHash(userForLogging.Password),
                RoleId = 1
            };

            context.Users.Add(user);
            context.SaveChanges();
        }

        public User Auth(AuthLogin login)
        {
            return context.Users.FirstOrDefault(u => u.Username == login.UserName
                && u.Password == cryptoService.SHA256GetHash(login.Password));
        }

        public void CreateContact(int userId, Contact contact)
        {
            contact.UserID = userId;
            context.Contacts.Add(contact);
            context.SaveChanges();
        }
    }
}
