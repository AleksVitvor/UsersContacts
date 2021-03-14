using Microsoft.AspNetCore.Html;
using System.Web.Mvc;

namespace FrontWeb.Helpers
{
    public static class LoginHelper
    {
        public static HtmlString CreateLogin()
        {
            TagBuilder form = new TagBuilder("form");
            TagBuilder divModel = new TagBuilder("div");
            divModel.MergeAttribute("asp-validation-summary", "ModelOnly");
            form.InnerHtml += divModel.ToString();
            TagBuilder divUserName = new TagBuilder("div");
            TagBuilder lableUserName = new TagBuilder("label");
            lableUserName.MergeAttribute("asp-for", "UserName");
            divUserName.InnerHtml += lableUserName;
            TagBuilder inputUserName = new TagBuilder("input");
            inputUserName.MergeAttribute("asp-for", "UserName");
            divUserName.InnerHtml += inputUserName;
            TagBuilder spanUserName = new TagBuilder("span");
            spanUserName.MergeAttribute("asp-validation-for", "UserName");
            divUserName.InnerHtml += spanUserName;
            form.InnerHtml += divUserName.ToString();

            TagBuilder divPassword = new TagBuilder("div");
            TagBuilder lablePassword = new TagBuilder("label");
            lablePassword.MergeAttribute("asp-for", "Password");
            divPassword.InnerHtml += lablePassword;
            TagBuilder inputPassword = new TagBuilder("input");
            inputPassword.MergeAttribute("asp-for", "Password");
            divPassword.InnerHtml += inputPassword;
            TagBuilder spanPassword = new TagBuilder("span");
            spanPassword.MergeAttribute("asp-validation-for", "Password");
            divPassword.InnerHtml += spanPassword;
            form.InnerHtml += divPassword.ToString();

            TagBuilder divSubmit = new TagBuilder("div");
            TagBuilder input = new TagBuilder("input");
            input.MergeAttribute("type", "submit");
            input.MergeAttribute("value", "Create");
            input.MergeAttribute("class", "btn btn-primary");
            divSubmit.InnerHtml += input;
            form.InnerHtml += divSubmit;

            form.MergeAttribute("asp-action", "Login");
            form.MergeAttribute("asp-controller", "Login");

            return new HtmlString(form.ToString());
        }
    }
}
