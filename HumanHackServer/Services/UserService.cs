using HumanHackServer.Models;

namespace HumanHackServer.Services
{
    public class UserService : IUserService
    {
        ApplicationContext db;
        public UserService(ApplicationContext context)
        {
            db = context;
        }
        public bool IsValidUserInformation(UserModel model)
        {
            var user = db.Users.FirstOrDefault(u => u.Email == model.Email && u.Password == model.Password);
            if (user != null)
            {
                return true;
            }
            return false;
        }
    }
}
