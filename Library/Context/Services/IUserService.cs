namespace Library.Context.Services
{
    using Library.Context.Models;
    using Library.FrontModels;


    public interface IUserService
    {
        void Register(FrontUserForLogging userForLogging);

        User Auth(AuthLogin login);

        void CreateContact(int userId, Contact contact);
    }
}
