package lld.LibraryManagementApp;

public class MemeberShipPlanFactory {

    private MemberShipPlanMonthly memebrShipPlanMonthly;
    private  MemberShipPlanYearly memberShipPlanYearly;

    public MemeberShipPlanFactory() {
        this.memebrShipPlanMonthly = new MemberShipPlanMonthly();
        this.memberShipPlanYearly = new MemberShipPlanYearly();
    }

    public MemberShipPlan getMemberShipObject(MembershipType membershipType) {
        if(membershipType == MembershipType.One_Month) {
            return memebrShipPlanMonthly;
        }
        if (membershipType == MembershipType.Yearly) {
            return memberShipPlanYearly;
        }
        return null;
    }
}
