using HumanHackServer.Models;

namespace HumanHackServer.Services
{
    public interface IUserService
    {
        UserModel GetUserDetails();
        bool IsValidUserInformation(UserModel model);
    }
}
