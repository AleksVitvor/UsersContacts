using Library.Context.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataWork.Repository
{
    public interface IUserRepository : IDisposable
    {
        IEnumerable<User> GetUsers();

        User GetUser(Func<User, bool> predicate);

        void Remove(Func<User, bool> predicate);

        void Save();
    }
}
