using System.ComponentModel.DataAnnotations;

namespace HumanHackServer.Models
{
    public class Role
    {
        [Key]
        public int Id { get; set; }
        public string Name { get; set; }
    }
}
