using DataWork.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataWork.UoW
{
    public interface IUoW : IDisposable
    {
        IContactsRepository contactsRepository { get; }

        IUserRepository userRepository { get; }
    }
}
