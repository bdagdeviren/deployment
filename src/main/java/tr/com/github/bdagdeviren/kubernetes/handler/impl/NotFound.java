package tr.com.github.bdagdeviren.kubernetes.handler.impl;

import fi.iki.elonen.NanoHTTPD.Response.IStatus;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import fi.iki.elonen.router.RouterNanoHTTPD.DefaultHandler;

import static fi.iki.elonen.NanoHTTPD.MIME_HTML;

public class NotFound extends DefaultHandler {

    public String getText() {
        return "<!DOCTYPE html><html lang=\"en\"><head> <meta charset=\"UTF-8\"> <title>404</title> <style>*{box-sizing: border-box; color: #FFFFFF; text-align: center;}body{background-color: #11191f;}section.notFound{display: flex; justify-content: center; align-items: center; height: calc(100vh - 16px);}section.notFound h1{color: red; font-size: 100px;}section.notFound h2{font-size: 50px;}section.notFound h1, h2, h3{margin-bottom: 20px;}div.text a{text-decoration: none; margin-right: 20px;}div.text a:hover{color: red; text-decoration: underline;}</style></head><body><section class=\"notFound\"> <div class=\"text\"> <h1 style=\"margin: 0\">404</h1> <h2 style=\"margin: 0\">PAGE NOT FOUND</h2> <h3><a href=\"/\" class=\"yes\">BACK TO HOME?</a></h3> </div></section></body></html>";
    }

    public String getMimeType() {
        return MIME_HTML;
    }

    public IStatus getStatus() {
        return Status.NOT_FOUND;
    }
}
