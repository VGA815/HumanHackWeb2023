using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace HumanHackServer.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class MLMController : ControllerBase
    {
        [HttpPost]
        public async Task<IActionResult> Tutu(string message)
        {
            //Load sample data
            var sampleData = new MLModel.ModelInput()
            {
                Message = message,
                Priority = @"medium_priority",
            };

            //Load model and predict output
            var result = MLModel.Predict(sampleData).PredictedLabel;
            return Ok(result);
        }
    }
}
