package ChapterTwo;

abstract class MedicalService {
    protected String serviceID;
    protected String serviceName;
    protected double baseCost;

    public MedicalService(String serviceID, String serviceName,
                          double baseCost) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.baseCost = baseCost;
    }

    public abstract double calculateTotalCost();

    public void displayServiceInfo() {
        System.out.println("Service ID: " + serviceID);
        System.out.println("Service: " + serviceName);
        System.out.printf("Total Cost: $%.2f%n",
                calculateTotalCost());
    }
}

class Consultation extends MedicalService {
    private double doctorFee;

    public Consultation(String serviceID, String serviceName,
                        double baseCost, double doctorFee) {
        super(serviceID, serviceName, baseCost);
        this.doctorFee = doctorFee;
    }

    @Override
    public double calculateTotalCost() {
        return baseCost + doctorFee;
    }
}

class LaboratoryTest extends MedicalService {
    private double testCharge;

    public LaboratoryTest(String serviceID, String serviceName,
                          double baseCost, double testCharge) {
        super(serviceID, serviceName, baseCost);
        this.testCharge = testCharge;
    }

    @Override
    public double calculateTotalCost() {
        return baseCost + testCharge;
    }
}

class Ultrasound extends MedicalService {
    private double additionalFee;

    public Ultrasound(String serviceID, String serviceName,
                      double baseCost, double additionalFee) {
        super(serviceID, serviceName, baseCost);
        this.additionalFee = additionalFee;
    }

    @Override
    public double calculateTotalCost() {
        return baseCost + additionalFee;
    }
}

public class HospitalBillingSystem {
    public static void main(String[] args) {

        MedicalService[] services = {
                new Consultation("S001", "Consultation", 15.0, 10.0),
                new LaboratoryTest("S002", "Laboratory Test", 10.0, 8.0),
                new Ultrasound("S003", "Ultrasound", 25.0, 15.0)
        };

        double totalHospitalBill = 0.0;

        System.out.println("===== HOSPITAL BILLING SYSTEM =====");
        System.out.println();

        for (MedicalService service : services) {
            service.displayServiceInfo();
            System.out.println();

            totalHospitalBill += service.calculateTotalCost();
        }

        System.out.println("---");
        System.out.printf("Total Hospital Bill: $%.2f%n",
                totalHospitalBill);
    }
}
