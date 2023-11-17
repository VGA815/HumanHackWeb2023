using HumanHackServer.Models;

namespace HumanHackServer.Services
{
    public class UserService : IUserService
    {
        ApplicationContext db;
        UserModel? userModel;
        public UserService(ApplicationContext context)
        {
            db = context;
        }
        public UserModel GetUserDetails()
        {
            return userModel;
        }
        public bool IsValidUserInformation(UserModel model)
        {
            var user = db.Users.FirstOrDefault(u => u.Email == model.Email && u.Password == model.Password);
            if (user != null)
            {
                userModel = model;
                return true;
            }
            return false;
        }
    }
}
