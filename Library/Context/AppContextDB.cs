namespace Library.Context
{
    using Library.Context.Models;
    using Microsoft.EntityFrameworkCore;
    using System.Diagnostics;

    public class AppContextDB:DbContext
    {
        public DbSet<Contact> Contacts { get; set; }
        public DbSet<User> Users { get; set; }
        public DbSet<Role> Roles { get; set; }

        public AppContextDB(DbContextOptions<AppContextDB> options)
            : base(options) { }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
            => optionsBuilder.LogTo(message => Debug.WriteLine(message));
    }
}
