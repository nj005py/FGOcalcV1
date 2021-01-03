package org.phantancy.fgocalc.item;

import java.util.List;

public class RemoteVersionItem {


    /**
     * version : 1.8.9
     * versionCode : 47
     * url : https://nj005py.github.io/FGOcalc_web/data/html/guide
     * content : [{"item":"数据库更新到302千子村正"},{"item":"请去度盘或群里下载最新安装包，本次无法数据库直接升级"},{"item":"修复更新检测功能"}]
     * db : 60
     */

    private String version;
    private int versionCode;
    private String url;
    private int db;
    private List<ContentBean> content;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("version:")
                .append(version)
                .append("\nversionCode:")
                .append(versionCode)
                .append("\nurl:")
                .append(url)
                .append("\ndb:")
                .append(db)
                .append("\ncontent:");
        for (ContentBean b : content) {
            sb.append("\nitem:")
                    .append(b.getItem());
        }
        return sb.toString();
    }

    public String getIntro() {
        StringBuilder sb = new StringBuilder()
                .append("version:")
                .append(version)
                .append("\nversionCode:")
                .append(versionCode)
                .append("\ndb:")
                .append(db);
        return sb.toString();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDb() {
        return db;
    }

    public void setDb(int db) {
        this.db = db;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * item : 数据库更新到302千子村正
         */

        private String item;

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }
    }
}
