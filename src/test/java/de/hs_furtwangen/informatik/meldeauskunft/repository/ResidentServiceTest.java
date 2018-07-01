package de.hs_furtwangen.informatik.meldeauskunft.repository;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;
import de.hs_furtwangen.informatik.meldeauskunft.service.ResidentServiceException;

public class ResidentServiceTest {

	private static final ResidentRepoStub rep = new ResidentRepoStub();
	private static final BaseResidentService service = new BaseResidentService();

	@BeforeClass
	public static void initialize() {
		service.setResidentRepository(rep);
	}

	@Test(expected = ResidentServiceException.class)
	public void uniqueResidentExceptionTest() throws ResidentServiceException {
		// service.setResidentRepository(rep);
		service.getUniqueResident(new Resident(null, null, null, null, null));
	}

	@Test(expected = ResidentServiceException.class)
	public void uniqueResidentWildcarsTest() throws ResidentServiceException {
		// service.setResidentRepository(rep);
		service.getUniqueResident(new Resident("*", null, null, null, null));
	}

	@Test(expected = ResidentServiceException.class)
	public void uniqueResidentWildcarsTest2() throws ResidentServiceException {
		// service.setResidentRepository(rep);
		service.getUniqueResident(new Resident("Name", "*", null, null, null));
	}

	@Test(expected = ResidentServiceException.class)
	public void uniqueResidentWildcarsTest3() throws ResidentServiceException {
		// service.setResidentRepository(rep);
		service.getUniqueResident(new Resident("Name", "Familie", "*", null,
				null));
	}

	@Test
	public void getFilteredResidentsListLeerTest() {
		int size = service.getFilteredResidentsList(
				new Resident("Hans", null, null, null, null)).size();
		assertEquals(size, 0);
	}

	@Test
	public void getFilteredResidentsListLeer2Test() {
		int size = service.getFilteredResidentsList(
				new Resident("T*", "T*", "Hans", null, null)).size();
		assertEquals(size, 0);
	}

	@Test
	public void getFilteredResidentsListLeer3Test() {
		int size = service.getFilteredResidentsList(
				new Resident("T*", "T", "Hans", null, null)).size();
		assertEquals(size, 0);
	}

}
