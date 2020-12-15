using Library.Context.Models;
using Microsoft.EntityFrameworkCore;

namespace Library.Context
{
    public class AppContextDB:DbContext
    {
        public DbSet<Contact> Contacts { get; set; }
        public DbSet<User> Users { get; set; }
        public DbSet<Role> Roles { get; set; }

        public AppContextDB(DbContextOptions<AppContextDB> options)
            : base(options) { }
    }
}
