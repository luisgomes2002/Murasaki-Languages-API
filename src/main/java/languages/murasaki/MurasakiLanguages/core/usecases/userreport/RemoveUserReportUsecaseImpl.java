package languages.murasaki.MurasakiLanguages.core.usecases.userreport;

import languages.murasaki.MurasakiLanguages.core.gateway.UserReportGateway;

public class RemoveUserReportUsecaseImpl implements RemoveUserReportUsecase {

    private final UserReportGateway userReportGateway;

    public RemoveUserReportUsecaseImpl(UserReportGateway userReportGateway) {
        this.userReportGateway = userReportGateway;
    }

    @Override
    public void execute(String name, String id) {
        userReportGateway.removeUserReport(name, id);
    }
}
