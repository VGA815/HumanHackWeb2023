using HumanHackServer.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace HumanHackServer.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CompetenciesController : ControllerBase
    {
        ApplicationContext db;
        public CompetenciesController(ApplicationContext context)
        {
            db = context;
        }
        [HttpGet]
        public async Task<IActionResult> GetCompetencies(string userEmail)
        {
            var user = db.Users.FirstOrDefault(u => u.Email == userEmail);
            if (user == null) return BadRequest();
            return Ok(user.Competencies);
        }
        [HttpPut]
        [Authorize(Roles = "admin")]
        public async Task<IActionResult> AddCompetencies(string competence, string userEmail)
        {
            var user = db.Users.FirstOrDefault(u => u.Email == userEmail);
            if (user == null) return BadRequest();
            user.Competencies.Add(competence, true);
            db.Update(user);
            await db.SaveChangesAsync();
            return Ok();
        }
        [HttpPost]
        [Authorize(Roles = "admin")]
        public async Task<IActionResult> SetCompetence(string competence, bool competenceValue, string userEmail)
        {
            var user = db.Users.FirstOrDefault(u => u.Email == userEmail);
            if (user == null) return BadRequest();

            user.Competencies[competence] = competenceValue;
            db.Update(user);
            await db.SaveChangesAsync();
            return Ok();
        }

    }
}
