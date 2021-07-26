namespace DataWork.Repository
{
    using Library.Context.Models;
    using Microsoft.EntityFrameworkCore;
    using System;
    using System.Collections.Generic;
    using System.Linq;


    public class UserRepository : IUserRepository
    {
        private readonly DbContext context;
        private readonly DbSet<User> set;

        public UserRepository(DbContext context)
        {
            this.context = context;
            set = this.context.Set<User>();
        }

        public User GetUser(Func<User, bool> predicate)
        {
            return set.FirstOrDefault(predicate);
        }

        public IEnumerable<User> GetUsers()
        {
            return set.AsEnumerable();
        }

        public void Remove(Func<User, bool> predicate)
        {
            set.Remove(GetUser(predicate));
        }

        public void Save()
        {
            context.SaveChanges();
        }

        #region IDisposableImpl
        private bool disposed = false;

        public virtual void Dispose(bool disposing)
        {
            if (!disposed)
            {
                if (disposing)
                {
                    context.Dispose();
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
