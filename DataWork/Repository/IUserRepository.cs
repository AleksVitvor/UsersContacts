namespace DataWork.Repository
{
    using Library.Context.Models;
    using System;
    using System.Collections.Generic;


    public interface IUserRepository : IDisposable
    {
        IEnumerable<User> GetUsers();

        User GetUser(Func<User, bool> predicate);

        void Remove(Func<User, bool> predicate);

        void Save();
    }
}
