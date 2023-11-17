using Microsoft.IdentityModel.Tokens;
using System.Text;

namespace HumanHackServer.Models
{
    public class AuthOptions
    {
        public const string ISSUER = "ItTechServer";
        public const string AUDIENCE = "ItTechClient";
        const string KEY = "secretSecret_key123_@256bits_secret";
        public static SymmetricSecurityKey GetSymmetricSecurityKey() =>
            new SymmetricSecurityKey(Encoding.UTF8.GetBytes(KEY));
    }
}
