namespace DataWork.Repository
{
    using Library.Context.Models;
    using System;
    using System.Collections.Generic;

    public interface IContactsRepository : IDisposable
    {
        void RemoveRange(IEnumerable<Contact> contacts);

        void Remove(Func<Contact, bool> predicate);

        void Update(Contact contact);

        Contact Get(Func<Contact, bool> predicate);

        void Save();
    }
}
