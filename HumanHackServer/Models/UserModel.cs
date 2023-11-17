using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations;

namespace HumanHackServer.Models
{
    public class UserModel
    {
        [Key]
        public int Id { get; set; }
        public string? Name { get; set; }
        [Required]
        public string? Email { get; set; }
        [Required]
        public string? Password { get; set; }

    }
}
