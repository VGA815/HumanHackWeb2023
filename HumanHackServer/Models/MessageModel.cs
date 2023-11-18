namespace HumanHackServer.Models
{
    public class MessageModel
    {
        public int Id { get; set; }
        public string? Text { get; set; }
        public string? Importance { get; set; }
        public string? Category { get; set; }
    }
}
