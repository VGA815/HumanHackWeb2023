using HumanHackServer.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore; 
using System.Text.Json;
namespace HumanHackServer.Controllers
{
    [EnableCors("CorsPolicy")]
    [Route("api/users")]
    [ApiController]
    public class UsersController : Controller
    {
        ApplicationContext db;
        public UsersController(ApplicationContext context)
        {
            db = context;
        }

        
        [HttpPost]
        [Authorize(Roles = "admin")]
        public async Task<IActionResult> AddEmployee(string jsonModel)
        {
            var usr = JsonSerializer.Deserialize<UserModel>(jsonModel);
            if (usr.Role.Name == "employee")
            {
                return BadRequest();
            }
            foreach (var user in db.Users.ToList())
            {
                if (user.Email == usr.Email)
                {
                    return StatusCode(401);
                }
            }
            db.Users.Add(usr);
            await db.SaveChangesAsync();
            return StatusCode(201);
        }


        [HttpGet]
        [Authorize(Roles = "admin, employee")]
        public async Task<IActionResult> GetUsers()
        {
            return Json(db.Users.ToList());
        }

        [HttpDelete]
        [Authorize(Roles = "admin")]
        public async Task<IActionResult> DeleteUser(string email)
        {
            if (email != null)
            {
                UserModel? user = await db.Users.FirstOrDefaultAsync(p => p.Email == email);
                if (user != null)
                {
                    db.Users.Remove(user);
                    await db.SaveChangesAsync();
                    return Ok();
                }
            }
            return NotFound();
        }

        [HttpPut]
        [Authorize(Roles = "admin")]
        public async Task<IActionResult> EditUser(string jsonModel)
        {
            db.Users.Update(JsonSerializer.Deserialize<UserModel>(jsonModel));
            await db.SaveChangesAsync();
            return Ok();
        }
    }
}
