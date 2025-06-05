package template;

public class Option {

    private static final int[] parafterupdate
            = new int[]{1, 110, 120, 130, 140, 150, 160, 172, 184, 196, 208, 220, 235, 250, 265, 280};
    public byte id;
    public int param;
    private short idItem;

    public Option(int id, int param, short iditem) {
        this.id = (byte) id;
        this.param = param;
        this.idItem = iditem;
    }

    public Option(int id, int param) {
        this.id = (byte) id;
        this.param = param;
    }

    // Phương thức getParamSt chuyển sang long và giới hạn 2 tỷ
    public int getParamSt(int tierSt) {
        if ((id >= 100 && id <= 107) || (id >= 58 && id <= 61)) {
            return param;
        }

        long parbuffer = (long) this.param;

        if (tierSt == 0) {
            return (int) Math.min(parbuffer, 2_000_000_000);
        }

        if (this.id >= 29 && this.id <= 36 || this.id >= 16 && this.id <= 22 || this.id == 41) {
            parbuffer += 20L * tierSt;
        } else if (this.id >= 23 && this.id <= 26) {
            parbuffer += 3;
        } else if (this.id == 42) {
            parbuffer += tierSt * 400L;
        } else if ((this.id >= 7 && this.id <= 13) || this.id == 15 || this.id == 27 || this.id == 28) {
            parbuffer += 100L * tierSt;
        } else if ((this.id == 37 || this.id == 38) && tierSt < 9) {
            return 1;
        } else if ((this.id >= 0 && this.id <= 6) || this.id == 14 || this.id == 40) {
            parbuffer = (parafterupdate[tierSt] * parbuffer) / 106L;
        }

        return (int) Math.min(parbuffer, 2_000_000_000);
    }

    // Phương thức getParam đã được điều chỉnh
    public int getParam(int tier) {
        if ((id >= 100 && id <= 107) || (id >= 58 && id <= 61) ) {
            return param;
        }
        if (Helps.CheckItem.isMeDay(idItem)) {
            return getParamMD(tier);
        }

        long parbuffer = (long) this.param;

        if (tier == 0) {
            return (int) Math.min(parbuffer, 2_000_000_000);
        }

        if ((id >= 29 && id <= 36) || (id >= 16 && id <= 22) || id == 41) {
            parbuffer += 20L * tier;
        } else if (id >= 23 && id <= 26) {
            parbuffer += tier;
        } else if (id == 42) {
            parbuffer += tier * 400L;
        } else if ((id >= 7 && id <= 13) || id == 15 || id == 27 || id == 28) {
            parbuffer += 100L * tier;
        } else if ((id == 37 || id == 38) && tier < 9) {
            return 1;
        } else if ((id >= 0 && id <= 6) || id == 14 || id == 40) {
            if (tier > 15) {
                tier = 15;
            }
            parbuffer = (parafterupdate[tier] * parbuffer) / 100L;
        }

        return (int) Math.min(parbuffer, 2_000_000_000);
    }

    // Phương thức getParamMD chuyển sang long và giới hạn 2 tỷ
    public int getParamMD(int tier) {
        if (tier == 0) {
            return param;
        }
        if ((this.id == 37 || this.id == 38)) {
            return 1;
        }

        long parbuffer = (long) this.param;

        if (this.id >= 0 && this.id <= 6) {
            parbuffer += (parbuffer * tier * 33L) / 100;
        } else if (this.id == 81 || this.id == 86 || this.id == 88 || this.id == 77 || this.id == 79) {
            parbuffer += (parbuffer * tier * 50L) / 100;
        } else if (this.id == 85 || this.id == 87 || this.id == 80 || this.id == 82) {
            parbuffer += (parbuffer * tier * 7L) / 100;
        } else if (this.id == 78 || this.id == 76) {
            parbuffer += (parbuffer * tier * 10L) / 100;
        } else if ((this.id >= 76 && this.id <= 89) || this.id == 97 || this.id == 98 || this.id == 95) {
            parbuffer += (parbuffer * tier * 7L) / 100;
        } else if (this.id >= 29 && this.id <= 36 || this.id >= 16 && this.id <= 22 || this.id == 41) {
            parbuffer += 50L * tier;
        } else if (this.id >= 23 && this.id <= 26) {
            parbuffer += tier;
        } else if (this.id == 42) {
            parbuffer += tier * 400L;
        } else if (this.id >= 7 && this.id <= 13) {
            parbuffer += this.param * tier;
        } else if (this.id == 15 || this.id == 27 || this.id == 28) {
            parbuffer += 100L * tier;
        } else if ((this.id >= 0 && this.id <= 6) || this.id == 14 || this.id == 40) {
            if (tier > 15) {
                tier = 15;
            }
            parbuffer = (parafterupdate[tier] * this.param) / 100L;
        }

        return (int) Math.min(parbuffer, 2_000_000_000);
    }

    public void setParam(int param) {
        this.param = param;
    }
}
