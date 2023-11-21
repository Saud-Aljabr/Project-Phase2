package Phase2;

public class test {

	public static void main(String[] args) {
		contactBST c = new contactBST();
		Contact one = new Contact("bf",4,"fkd","dvgdv","dvdfd","hmn,");
		Contact t = new Contact("adfvv",23,"fbn","dvgdv","dvdfd","hmn,");
		Contact h = new Contact("skm",32,"gfhf","dvgdv","dvdfd","hmn,");
		Contact f = new Contact("kldsmvflk",45,"fgh","dvgdv","dvdfd","hmn,");
		c.insert(one);
		c.insert(t);
		c.insert(h);
		c.insert(f);
	
		c.display();
		System.out.println(c.remove_Key("gbf"));
		//System.out.println(c.travEmail("fgh").getName());
	}

}
