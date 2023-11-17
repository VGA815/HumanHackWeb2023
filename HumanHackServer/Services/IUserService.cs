using HumanHackServer.Models;

namespace HumanHackServer.Services
{
    public interface IUserService
    {
        bool IsValidUserInformation(UserModel model);
    }
}
