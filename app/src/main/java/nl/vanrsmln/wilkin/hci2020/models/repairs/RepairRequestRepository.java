package nl.vanrsmln.wilkin.hci2020.models.repairs;

import nl.vanrsmln.wilkin.hci2020.Constants;

import java.util.*;

public class RepairRequestRepository {

    List<RepairRequest> publicRequests;
    List<RepairRequest> myRequests;
    List<RepairRequest> acceptedRequests;

    private static RepairRequestRepository instance = new RepairRequestRepository();

    public static RepairRequestRepository getInstance() {
        return instance;
    }

    private RepairRequestRepository() {
        publicRequests = Constants.repairRequests;
        myRequests = new ArrayList<>();
        acceptedRequests = new ArrayList<>();
        makeAcceptedRequests();
    };

    public List<RepairRequest> getPublicRequests() {
        return publicRequests;
    }

    public List<RepairRequest> getMyRequests() {
        return myRequests;
    }

    public List<RepairRequest> orderOnDate(List<RepairRequest> repairRequests) {
        Collections.sort(repairRequests, (t1, t2) -> t2.date.compareTo(t1.date));
        return repairRequests;
    }

    public void makeAcceptedRequests() {
        acceptedRequests = new ArrayList<>();
        acceptedRequests.addAll(publicRequests);
        acceptedRequests.addAll(myRequests);

        for(RepairRequest r : acceptedRequests) {
            if (!r.status.isAccepted()) {
                acceptedRequests.remove(r);
            }
        }

        Collections.sort(acceptedRequests, (t1, t2) -> t2.date.compareTo(t1.date));
    }

    public List<RepairRequest> getAcceptedRequests() {
        return acceptedRequests;
    }

}
