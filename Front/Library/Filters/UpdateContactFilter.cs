using System;
using System.Collections.Generic;
using System.Text;

namespace Library.Filters
{
    public class UpdateContactFilter
    {
        public string ContactName { get; set; }

        public string ContactSurname { get; set; }

        public string ContactPhoneNumber { get; set; }

        public long ContactId { get; set; }
    }
}
