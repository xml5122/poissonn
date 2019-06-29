package com.poissonn.constance;

/**
 * 菜单权限
 */
public enum MenuRoot {

    MANAGER("1","管理员"),
    SELLER("2","卖家"),
    OTHER("3","其他");

    MenuRoot(String roleCode,String roleName){
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    private String roleCode;
    private String roleName;


    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public static String getCodeByName(String name){
        for (MenuRoot menuRoot :MenuRoot.values()){
            if (menuRoot.getRoleName().equals(name)){
                return menuRoot.getRoleCode();
            }
        }
        return null;
    }

    public static String getNameByCode(String code){
        for (MenuRoot menuRoot :MenuRoot.values()){
            if (menuRoot.getRoleCode().equals(code)){
                return menuRoot.getRoleName();
            }
        }
        return null;
    }


}
