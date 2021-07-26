namespace Library.Context.Models
{
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    [Table("contacts")]
    public class Contact
    {
        [Key, DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Column("CONTACT_ID")]
        public int ContactId { get; set; }

        [Required]
        [Column("CONTACT_NAME")]
        public string ContactName { get; set; }

        [Column("CONTACT_SURNAME")]
        public string ContactSurname { get; set; }

        [Required(ErrorMessage = "You must provide a phone number")]
        [Column("CONTACT_PHONE")]
        [RegularExpression(@"^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$", ErrorMessage = "Not a valid phone number")]
        public string PhoneNumber { get; set; }

        [Required]
        [Column("USER_ID")]
        [ForeignKey("User")]
        public int UserID { get; set; }

        public virtual User User { get; set; }
    }
}
