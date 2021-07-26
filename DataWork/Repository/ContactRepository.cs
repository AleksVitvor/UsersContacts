namespace DataWork.Repository
{
    using Library.Context.Models;
    using Microsoft.EntityFrameworkCore;
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class ContactRepository : IContactsRepository
    {
        private readonly DbContext context;
        private readonly DbSet<Contact> set;

        public ContactRepository(DbContext context)
        {
            this.context = context;
            set = this.context.Set<Contact>();
        }

        public Contact Get(Func<Contact, bool> predicate)
        {
            return set.FirstOrDefault(predicate);
        }

        public void Remove(Func<Contact, bool> predicate)
        {
            set.Remove(Get(predicate));
        }

        public void RemoveRange(IEnumerable<Contact> contacts)
        {
            set.RemoveRange(contacts);
        }

        public void Update(Contact contact)
        {
            set.Update(contact);
            context.SaveChanges();
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
