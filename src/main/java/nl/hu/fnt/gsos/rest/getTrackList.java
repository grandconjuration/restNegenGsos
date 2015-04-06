package nl.hu.fnt.gsos.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import nl.hu.fnt.gsos.service.ServiceProvider;
import nl.hu.fnt.gsos.service.Track;
import nl.hu.fnt.gsos.service.TrackServiceImpl;

@Path("/tracks")
public class getTrackList {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTracks() {

		new ServiceProvider();
		TrackServiceImpl ts = ServiceProvider.getTrackService();
		List<Track> trackList = ts.getTracks();
		Gson gson = new Gson();
		String trackString = gson.toJson(trackList);
		return trackString;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/count")
	public String getTrackCount() {
		new ServiceProvider();
		TrackServiceImpl ts = ServiceProvider.getTrackService();
		List<Track> trackList = ts.getTracks();
		Integer number = trackList.size();
		Gson gson = new Gson();
		String trackString = gson.toJson(number);
		return trackString;

	}	
	@GET
	@Path("{subResources: [0-9]+}")
	public String get(@PathParam("subResources") int subResources) {
		new ServiceProvider();
		TrackServiceImpl ts = ServiceProvider.getTrackService();
		Track t = ts.getTrackById(subResources);
		Gson gson = new Gson();
		String trackString = gson.toJson(t);
		return trackString;
	}	
}