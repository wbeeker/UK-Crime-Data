package Model;
public class CrimeBeanMapper {

    private CrimeBeanMapper() {
    }

    public static Crime map(CrimeBean bean) {
        return new Crime(bean.getCategory(),
                bean.getLocation().getLatitude(),
                bean.getLocation().getStreet().getId(),
                bean.getLocation().getStreet().getName(),
                bean.getLocation().getLongitude(),
                bean.getOutcomeStatus().getCategory(),
                bean.getOutcomeStatus().getDate(),
                bean.getPersistentID(),
                bean.getId(),
                bean.getMonth()
        );
    }
}
