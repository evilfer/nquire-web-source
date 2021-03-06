package org.greengin.nquireit.logic.admin;

/**
 * nQuire-it - backend and web-service API for nQuire-it (Java sources).
 *
 * License: GNU GPL-3.0+ (https://gnu.org/licenses/gpl.html)
 * Copyright © 2014-2016 The Open University (IET-OU).
 */

import org.greengin.nquireit.entities.projects.Project;
import org.greengin.nquireit.entities.users.UserProfile;
import org.greengin.nquireit.logic.AbstractContentManager;
import org.greengin.nquireit.logic.ContextBean;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

public class AdminActions extends AbstractContentManager {

    boolean isAdmin;

    public AdminActions(ContextBean context, UserProfile user, boolean tokenOk) {
        super(context, user, tokenOk);
        init();
    }

    public AdminActions(ContextBean context, HttpServletRequest request) {
        super(context, request);
        init();
    }

    private void init() {
        this.isAdmin = loggedWithToken && user.isAdmin();
    }


    public List<UserProfile> getUsers() {
        return isAdmin ? context.getUserProfileDao().listUsers() : null;
    }

    public void setAdmin(Long userId, UserAdminRequest data) {
        if (isAdmin) {
            context.getUserProfileDao().setAdmin(userId, data.isAdmin());
        }
    }

    public List<Project> getProjects() {
        return isAdmin ? context.getProjectDao().getProjects() : null;
    }

    public void setFeatured(Long projectId, ProjectFeaturedRequest data) {
        if (isAdmin) {
            context.getProjectDao().setFeatured(projectId, data.isFeatured());
        }
    }

    public void setProjectFilters(Long projectId, ProjectFiltersRequest data) {
        if (isAdmin) {
            context.getProjectDao().setFilters(projectId, data.getFilters());
        }
    }

    public Boolean updateModel() {
        if (isAdmin) {
            context.getProjectDao().updateDataModel();
            return true;
        }
        return false;
    }

    public Boolean setText(String textId, String content) {
        if (isAdmin) {
            return context.getTextDao().setText(textId, content);
        }

        return false;

    }

    public Boolean setFilter(String label, String query, Long id) {
        if (isAdmin) {
            return context.getFilterDao().setFilter(label, query, id);
        }
        return false;

    }

    public Boolean deleteFilter(Long filterId) {
        if (isAdmin) {
            return context.getFilterDao().deleteFilter(filterId);
        }
        return false;

    }

    public HashMap<String, List<ReportedContent>> getReportedContent() {
        if (isAdmin) {
            return context.getVotableDao().getReportedContent(context);
        } else {
            return null;
        }
    }

    public HashMap<String, List<ReportedContent>> deleteReportedContent(Long id) {
        if (isAdmin) {
            context.getVotableDao().deleteReportedEntity(user, id);
            return context.getVotableDao().getReportedContent(context);
        } else {
            return null;
        }
    }

    public HashMap<String, List<ReportedContent>> approveReportedContent(Long id) {
        if (isAdmin) {
            context.getVotableDao().approveReportedEntity(user, id);

            return context.getVotableDao().getReportedContent(context);
        } else {
            return null;
        }
    }
}
