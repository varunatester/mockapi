package entities;

public class EditAddressResponse {
    private String addressId;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }


    public GetAddressByIdResponse getAddressById() {
        return new GetAddressByIdResponse();
    }

    public DeleteAddressResponse deleteAddress() {
        return new DeleteAddressResponse();
    }
}
