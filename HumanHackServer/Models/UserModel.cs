using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

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

        public int RoleId { get; set; }
        [Required]
        [ForeignKey("RoleId")]
        public Role? Role { get; set; }
        public Dictionary<string, bool> Competencies = new() 
        {
            { "is_competent_in_payment_issue", false },
            { "is_competent_in_create_account",false },
            { "is_competent_in_contact_customer_service", false },
            { "is_competent_in_get_invoice", false },
            { "is_competent_in_track_order", false },
            { "is_competent_in_get_refund", false },
            { "is_competent_in_contact_human_agent", false },
            { "is_competent_in_recover_password", false },
            { "is_competent_in_change_order", false },
            { "is_competent_in_delete_account", false },
            { "is_competent_in_complaint", false },
            { "is_competent_in_check_invoices", false },
            { "is_competent_in_review", false },
            { "is_competent_in_check_refund_policy", false },
            { "is_competent_in_delivery_options", false },
            { "is_competent_in_check_cancellation_fee", false },
            { "is_competent_in_track_refund", false },
            { "is_competent_in_check_payment_methods", false },
            { "is_competent_in_switch_account", false },
            { "is_competent_in_newsletter_subscription", false },
            { "is_competent_in_delivery_period", false },
            { "is_competent_in_edit_account", false },
            { "is_competent_in_registration_problems", false },
            { "is_competent_in_change_shipping_address", false },
            { "is_competent_in_set_up_shipping_address", false },
            { "is_competent_in_place_order", false },
            { "is_competent_in_cancel_order", false }
        };
        public List<MessageModel> Messages { get; set; } = new();

    }
}
