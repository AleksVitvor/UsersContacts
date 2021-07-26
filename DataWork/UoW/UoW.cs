using DataWork.Repository;
using Library.Context;
using System;

namespace DataWork.UoW
{
    public class UoW : IUoW
    {
        private AppContextDB db;
        private ContactRepository ContactRepository;
        private UserRepository UserRepository;

        public IUserRepository userRepository
        {
            get
            {
                if (UserRepository == null)
                    UserRepository = new UserRepository(db);
                return UserRepository;
            }
        }

        public IContactsRepository contactsRepository
        {
            get
            {
                if (ContactRepository == null)
                    ContactRepository = new ContactRepository(db);
                return ContactRepository;
            }
        }
        public UoW(AppContextDB context)
        {
            db = context;
        }

        #region IDisposableImpl
        private bool disposed = false;

        public virtual void Dispose(bool disposing)
        {
            if (!disposed)
            {
                if (disposing)
                {
                    db.Dispose();
                }
                disposed = true;
            }
        }

        public void Dispose()
        {
            Dispose(true);
            GC.SuppressFinalize(this);
        }
        #endregion
    }
}
