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

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Role>().HasData(new Role[] 
            {
                new Role
                    {
                        RoleId = 1,
                        RoleName = "ROLE_USER"
                    },
                new Role
                    {
                        RoleId = 2,
                        RoleName = "ROLE_ADMIN"
                    }
            });

            modelBuilder.Entity<User>().HasData(
                new User[]
                    {
                        new User
                            {
                                UserId = 1,
                                Contacts = null,
                                Password = "435c554a2e9cd54d2d3431b8af2b5d7ba740c64f1dca92b7af8a76b05d484ef3",
                                RoleId = 2,
                                Username = "admin"
                            }
                    });
        }
    }
}
