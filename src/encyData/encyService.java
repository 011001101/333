package encyData;

import java.util.ArrayList;
import java.util.List;

public class encyService {
private encyRepository repo;
	
	public encyService(encyRepository repo) {
		this.repo = repo;
	}
	
	public List<ency> getEncyDocuments(int page) {
		List<ency> list = new ArrayList<>();
		System.out.println(page);
		int test = (page - 1) * 2;
		if(test == -2) {
			test = 0;
		}
		list.add(repo.getById(test));
			
		
		return list;
	}
	public static void main(String[] args) {
		encyRepository abc = new encyRepository();
		encyService ee = new encyService(abc);
		System.out.println(ee.getEncyDocuments(0).toString());
	}
}
