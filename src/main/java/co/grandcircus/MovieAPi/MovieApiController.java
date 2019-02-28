package co.grandcircus.MovieAPi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.MovieAPi.Model.Movie;
import co.grandcircus.MovieAPi.Model.MovieDetail;

@Controller
public class MovieApiController {

	@Autowired
	private ApiService apiService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		Integer page = 2;
		List<Movie> movieList = apiService.movieList(page);
		return new ModelAndView("index", "movies", movieList);
	}
	
	@RequestMapping("/details")
	public ModelAndView details(
			@RequestParam("id") Integer id
			) {
		MovieDetail details = apiService.movieDetail(id);
		return new ModelAndView("Details","details", details);
	}
}