namespace Library.Context.Services
{
    using System;
    using System.Security.Cryptography;
    using System.Text;

    public class CryptoService : ICryptoService
    {
        public string SHA256GetHash(string source)
        {
            using (SHA256 sha256Hash = SHA256.Create())
            {
                byte[] sourceBytes = Encoding.UTF8.GetBytes(source);
                byte[] hashBytes = sha256Hash.ComputeHash(sourceBytes);
                string hash = BitConverter.ToString(hashBytes).Replace("-", string.Empty);

                return hash;
            }
        }
    }
}