package entities;

public class LocalAddress extends CreateAddressRequest {
    @Override
    public float getShippingCharges() {
        return 100;
    }
}
