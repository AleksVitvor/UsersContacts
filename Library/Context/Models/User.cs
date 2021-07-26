namespace Library.Context.Models
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    [Table("users")]
    public class User
    {
        [Key, DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Column("USER_ID")]
        public int UserId { get; set; }
        
        [Required]
        [Column("USER_USERNAME")]
        public string Username { get; set; }

        [Required]
        [Column("USER_PASSWORD")]
        public string Password { get; set; }

        [Required]
        [Column("ROLE_ID")]
        [ForeignKey("Role")]
        public int RoleId { get; set; }
        public virtual Role Role { get; set; }

        public virtual ICollection<Contact> Contacts { get; set; }
    }
}
