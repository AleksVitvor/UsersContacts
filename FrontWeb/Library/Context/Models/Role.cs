using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Library.Context.Models
{
    [Table("roles")]
    public class Role
    {
        [Key, DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Column("ROLE_ID")]
        public int RoleId { get; set; }

        [Required]
        [Column("ROLE_NAME")]
        public string RoleName { get; set; }

        public virtual ICollection<User> Users { get; set; }
    }
}