package com.github.vinoses.jerseyemberbsdwrsendgrid;

import org.directwebremoting.datasync.ExposeToString;

import java.util.Random;

@ExposeToString
public class Data
{
  /**
   * Create a blank data
   */
  public Data()
  {
    this.id = getNextId();
  }

  /**
   * Create a data with random values
   */
  public Data(boolean withRandom)
  {
    if (withRandom)
    {

      this.superhero = random.nextInt(100) == 1;
    }

    this.id = getNextId();
  }

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  private String id;

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  private String name;

  public String getAddress() { return address; }
  public void setAddress(String address) { this.address = address; }
  private String address;

  public int getAge() { return age; }
  public void setAge(int age) { this.age = age; }
  private int age;

  public boolean isSuperhero() { return superhero; }
  public void setSuperhero(boolean superhero) { this.superhero = superhero; }
  private boolean superhero;

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
  {
    return name;
  }

  /**
   * Get the next unique ID in a thread safe way
   * @return a unique id
   */
  public static synchronized String getNextId()
  {
    return "P" + (nextId++);
  }

  /**
   * The next ID, to get around serialization issues
   */
  private static int nextId = 1;

  private static final Random random = new Random();
}
